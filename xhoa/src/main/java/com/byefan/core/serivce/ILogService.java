package com.byefan.core.serivce;

import com.byefan.core.entity.Log;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;

public interface ILogService {
    boolean save(Log log);

    PageInfo<Log> all(Pageable pageable);

    boolean del(Integer id);

    PageInfo<Log> search(Log log, Pageable pageable);

    Log get(Integer id);
}
