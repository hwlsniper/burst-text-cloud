package com.burst.text.service;

import com.burst.text.model.SysDictionaryBean;

import java.util.List;

public interface SysDictionaryService {

    List<SysDictionaryBean> querySysDictList(String dataType);
}
