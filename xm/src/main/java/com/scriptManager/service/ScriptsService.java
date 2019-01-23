package com.scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scriptManager.entity.Scripts;
import com.scriptManager.mapper.ScriptsMapper;
import com.common.util.ContextUtil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ScriptsService implements IScriptsService{
    @Autowired
    ScriptsMapper scriptsMapper;

    @Override
    public int addScripts(Scripts scripts) {
        scripts.setId(UUID.randomUUID().toString());
        scripts.setUserId(ContextUtil.getUser().getId());
        return scriptsMapper.addScripts(scripts);
    }

    public List<Map> queryList(Map map){
        return scriptsMapper.queryList(map);
    }

    public int update(Scripts scripts){
        return scriptsMapper.update(scripts);
    }
}
