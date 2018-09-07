package com.serhatsurguvec.androidcleankotlin.core.di;

import javax.inject.Scope;

import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Scope
@Retention()
@Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.FUNCTION})
public @interface FragmentScoped {

}