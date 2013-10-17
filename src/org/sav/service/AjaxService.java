package org.sav.service;

import javax.servlet.http.HttpServletRequest;

public interface AjaxService{

    Object invokeAction(String action, HttpServletRequest request);

}
