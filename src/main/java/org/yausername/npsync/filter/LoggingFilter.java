package org.yausername.npsync.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(SecurityProperties.DEFAULT_FILTER_ORDER-1)
public class LoggingFilter extends OncePerRequestFilter {
    
    @Autowired
    private ObjectMapper mapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        doFilterWrapped(wrapRequest(request), wrapResponse(response), filterChain);
    }

    protected void doFilterWrapped(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } finally {
            
            Map<String, Object> requestMap = new HashMap<>();
            Map<String, List<String>> requestHeaders = Collections.list(request.getHeaderNames()).stream()
                    .map(key -> Pair.of(key, Collections.list(request.getHeaders(key))))
                    .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
            requestMap.put("headers", requestHeaders);
            requestMap.put("params", request.getParameterMap());
            requestMap.put("body", new String(request.getContentAsByteArray(), request.getCharacterEncoding()));
            
            
            Map<String, Object> responseMap = new HashMap<>();
            Map<String, Collection<String>> responseHeaders = response.getHeaderNames().stream()
                    .map(key -> Pair.of(key, response.getHeaders(key)))
                    .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
            responseMap.put("headers", responseHeaders);
            responseMap.put("body", new String(response.getContentAsByteArray(), response.getCharacterEncoding()));
            
            Map<String, Object> loggingMap = new HashMap<>();
            loggingMap.put("request", requestMap);
            loggingMap.put("response", responseMap);
            
            loggingMap.put("method", request.getMethod());
            loggingMap.put("status", response.getStatusCode());
            loggingMap.put("url", request.getRequestURL());
            
            
            response.copyBodyToResponse();
            log.info(mapper.writeValueAsString(loggingMap));
        }
    }

    private static ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
        if (request instanceof ContentCachingRequestWrapper) {
            return (ContentCachingRequestWrapper) request;
        } else {
            return new ContentCachingRequestWrapper(request);
        }
    }

    private static ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper) {
            return (ContentCachingResponseWrapper) response;
        } else {
            return new ContentCachingResponseWrapper(response);
        }
    }
}
