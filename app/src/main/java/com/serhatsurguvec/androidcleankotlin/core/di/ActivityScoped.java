package com.serhatsurguvec.androidcleankotlin.core.di;

import java.lang.annotation.Documented;

import javax.inject.Scope;

import kotlin.annotation.Retention;

/**
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * {@link ApplicationComponent} is a scoped component ({@code @Singleton}, we create a custom
 * scope to be used by all fragment components. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
@Documented
@Scope
@Retention()
public @interface ActivityScoped {
}