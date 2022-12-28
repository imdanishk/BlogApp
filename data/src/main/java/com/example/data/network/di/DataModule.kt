package com.example.data.network.di

import android.content.Context
import com.example.common.Constant
import com.example.data.network.ApiService
import com.example.data.repository.GetGetBlogsRepositoryImpl
import com.example.data.room.BlogDAO
import com.example.data.room.BlogDatabase
import com.example.domain.repository.GetBlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideGetBlogsRepository(apiService: ApiService): GetBlogsRepository {
        return GetGetBlogsRepositoryImpl(apiService = apiService)
    }

    @Provides
    fun provideBlogDatabase(@ApplicationContext context: Context): BlogDatabase {
        return BlogDatabase.getInstance(context)
    }

    @Provides
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDAO {
        return blogDatabase.getBlogDAO()
    }
}