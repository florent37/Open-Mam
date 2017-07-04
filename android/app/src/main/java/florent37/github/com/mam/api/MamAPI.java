package florent37.github.com.mam.api;

import florent37.github.com.mam.model.AppResponse;
import florent37.github.com.mam.model.AppsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by florentchampigny on 18/06/2017.
 */

public interface MamAPI {

    @GET("api.php?method=apps&platform=android")
    Single<AppsResponse> apps();

    @GET("api.php?method=app&platform=android")
    Single<AppResponse> app(@Query("name") String name);

}
