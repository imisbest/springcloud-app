package com.csw.service;

import com.csw.dao.IntoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InfoServiceImpl implements IntoService {
    @Autowired
    private IntoDao intoDao;
}
