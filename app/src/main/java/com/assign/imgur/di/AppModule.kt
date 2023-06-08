package com.assign.imgur.di

import androidx.lifecycle.ViewModel
import com.assign.imgur.di.ViewModelFactory
import com.assign.imgur.interfaces.GalleryHttpInterface
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.repository.GalleryRepositoryImpl
import com.assign.imgur.utils.AppDelegate
import com.assign.imgur.utils.RetrofitClient
import com.assign.imgur.viewmodels.GalleryViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGalleryHttpInterface() : GalleryHttpInterface {
        return RetrofitClient.getClientWithInterceptor(AppDelegate.getInstance().clientID)
            .create(GalleryHttpInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideGalleryRepository(galleryHttpInterface: GalleryHttpInterface) : GalleryRepository {
        return GalleryRepositoryImpl(galleryHttpInterface)
    }
}