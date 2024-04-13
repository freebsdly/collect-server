package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.FileContentDTO;
import top.qinhuajun.collectserver.collectci.infra.FileContentHistoryRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileContentHistoryDAO;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@Slf4j
public class FileSyncCommandService {

    private final BlockingQueue<Pair<String, FileContentDTO>> queue = new LinkedBlockingQueue<>();

    private final FileContentHistoryRepository fileContentHistoryRepository;
    private final ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    public FileSyncCommandService(FileContentHistoryRepository fileContentHistoryRepository, ThreadPoolExecutor threadPoolExecutor) {
        this.fileContentHistoryRepository = fileContentHistoryRepository;
        this.threadPoolExecutor = threadPoolExecutor;
        this.threadPoolExecutor.submit(this::run);
    }

    private void run() {
        try {
            while (true) {
                Pair<String, FileContentDTO> data = queue.take();
                FileContentHistoryDAO entity = DTOMapper.INSTANCE.toHistoryEntity(data.getSecond());
                entity.setId(null);
                fileContentHistoryRepository.save(entity);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            log.error("collect file sync interrupted");
        }
    }

    public void add(String action, FileContentDTO dto) {
        queue.add(Pair.of(action, dto));
    }
}
