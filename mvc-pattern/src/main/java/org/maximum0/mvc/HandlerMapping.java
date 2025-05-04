package org.maximum0.mvc;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
