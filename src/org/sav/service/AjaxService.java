package org.sav.service;

import javax.servlet.http.HttpServletRequest;

public interface AjaxService{

    AjaxResult invokeAction(String action, HttpServletRequest request);

}
