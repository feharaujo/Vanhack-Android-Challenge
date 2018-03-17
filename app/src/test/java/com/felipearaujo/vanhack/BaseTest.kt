package com.felipearaujo.vanhack

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations

/**
 * Created by felipearaujo on 17/03/18.
 */
@RunWith(JUnit4::class)
abstract class BaseTest {

    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    open fun after() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

}