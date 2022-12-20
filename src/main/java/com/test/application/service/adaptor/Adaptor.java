package com.test.application.service.adaptor;

import java.util.List;

/**
 * @author invzbl3 on 12/20/2022
 * @project RestApiApplication
 */
public interface Adaptor<UI, DB> {

    public List<DB> uiDtoToDatabaseModelList(List<UI> uiobj);

    public List<UI> databaseModelToUiDtoList(List<DB> dbobj);

    public DB uiDtoToDatabaseModel(UI uiobj);

    public UI databaseModelToUiDto(DB dbobj);
}