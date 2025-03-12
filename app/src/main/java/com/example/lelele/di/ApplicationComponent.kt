package com.example.lelele.di

import android.app.Application
import com.example.lelele.presentation.MainActivity.MainActivity
import com.example.lelele.presentation.collectionActivity.CollectionActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: CollectionActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}