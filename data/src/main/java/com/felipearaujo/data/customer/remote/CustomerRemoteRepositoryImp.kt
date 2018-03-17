package com.felipearaujo.data.customer.remote

import com.felipearaujo.data.customer.local.CustomerLocalRepository
import io.reactivex.Completable

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerRemoteRepositoryImp(
        private val service: CustomerService,
        private val localRepository: CustomerLocalRepository
) : CustomerRemoteRepository {

    override fun doLogin(email: String, password: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createAccount(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /*override fun fetchProjects(): Single<Response> {
        val cacheResponse = service.fetchAllProject2()
                .flatMapIterable {
                    it.projects
                }
                .flatMap {
                    Observable.zip(
                            Observable.just(it),
                            service.fetchActivities(it.id!!),
                            BiFunction<ProjectsItem, ResponseActivity, ProjectsItem> {
                                first: ProjectsItem, second: ResponseActivity ->
                                    first.setActivitiesList(second.activity as List<ActivityItem>)
                            }
                    )
                }
                .toList()
                .map { Response("ok", it.toList()) }
                .cache()

        localRepository.saveCacheData(cacheResponse)

        return cacheResponse
    }
*/
}