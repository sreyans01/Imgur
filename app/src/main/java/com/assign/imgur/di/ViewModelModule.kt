package com.assign.imgur.di

import androidx.lifecycle.ViewModel
import com.assign.imgur.di.ViewModelFactory
import com.assign.imgur.viewmodels.GalleryViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
    @Retention(
        RetentionPolicy.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }


    @Provides
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    fun galleryViewModel(): ViewModel {
        return GalleryViewModel()
    }
}