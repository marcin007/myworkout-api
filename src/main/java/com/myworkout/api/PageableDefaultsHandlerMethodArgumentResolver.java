package com.myworkout.api;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

public class PageableDefaultsHandlerMethodArgumentResolver extends PageableHandlerMethodArgumentResolver {

    @Override
    public Pageable resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
                                    NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

        Pageable p = super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);

        Optional<PageableDefaults> optionalPageableDefaults =
                Optional.ofNullable(methodParameter.getParameterAnnotation(PageableDefaults.class));

        if (optionalPageableDefaults.isPresent()) {
            PageableDefaults defaults = optionalPageableDefaults.get();

            int size = p.getPageSize() == 20 ? defaults.size() : p.getPageSize();

            if (size > defaults.maxSize()) {
                size = defaults.maxSize();
            } else if (size < defaults.minSize()) {
                size = defaults.minSize();
            }

            p = PageRequest.of(p.getPageNumber(), size, p.getSort());
        }

        return p;
    }
}
