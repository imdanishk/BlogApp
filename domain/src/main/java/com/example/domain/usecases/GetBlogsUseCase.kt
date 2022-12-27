package com.example.domain.usecases

import com.example.common.Resource
import com.example.domain.model.Blog
import com.example.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(
    private val getBlogsRepository: GetBlogsRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Blog>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = getBlogsRepository.getBlogs()
            emit(Resource.Success(data = response))
        }
        catch (e: Exception) {
            emit(Resource.Error("Error Occurred"))
        }
    }
}