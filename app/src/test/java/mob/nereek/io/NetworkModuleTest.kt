package mob.nereek.io.di.module

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations



class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Mock
    private lateinit var app: Application

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        networkModule = NetworkModule
    }

    @Test
    fun testOkhttpCache() {
        val cache = networkModule.provideOkhttpCache(app)
        assertNotNull(cache)
    }

    @Test
    fun testClient() {
        val loggingInterceptor = networkModule.provideLoggingInterceptor()
        val cache = networkModule.provideOkhttpCache(app)
        val client = networkModule.provideClient(loggingInterceptor, cache)
        assertNotNull(client)
    }

    @Test
    fun testMoshi() {
        val moshi = networkModule.provideMoshi()
        assertNotNull(moshi)
    }

    @Test
    fun testMoshiConverter() {
        val moshi = networkModule.provideMoshi()
        val moshiConverter = networkModule.provideMoshiConverter(moshi)
        assertNotNull(moshiConverter)
    }

    @Test
    fun testRetrofit() {
        val moshi = networkModule.provideMoshi()
        val moshiConverter = networkModule.provideMoshiConverter(moshi)
        val loggingInterceptor = networkModule.provideLoggingInterceptor()
        val cache = networkModule.provideOkhttpCache(app)
        val client = networkModule.provideClient(loggingInterceptor, cache)
        val retrofit = networkModule.provideRetrofit(moshiConverter, client)
        assertNotNull(retrofit)
    }

    @Test
    fun testService() {
        val moshi = networkModule.provideMoshi()
        val moshiConverter = networkModule.provideMoshiConverter(moshi)
        val loggingInterceptor = networkModule.provideLoggingInterceptor()
        val cache = networkModule.provideOkhttpCache(app)
        val client = networkModule.provideClient(loggingInterceptor, cache)
        val retrofit = networkModule.provideRetrofit(moshiConverter, client)
        val service = networkModule.provideService(retrofit)
        assertNotNull(service)
    }
}
