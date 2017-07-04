package mam.repository;


import java.util.Arrays;
import java.util.List;

import florent37.github.com.mam.api.MamAPI;
import florent37.github.com.mam.model.App;
import florent37.github.com.mam.model.AppVersion;
import florent37.github.com.mam.repository.AppRepository;
import io.reactivex.Single;

public class AppRepositoryImpl implements AppRepository {

    public AppRepositoryImpl(MamAPI mamAPI) {

    }

    public Single<List<App>> applications() {
        return Single.fromCallable(() -> Arrays.asList(
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000"),
                new App("Facebook", "1.0.0", "https://lh3.googleusercontent.com/ZZPdzvlpK9r_Df9C3M7j1rNRi7hhHRvPhlklJ3lfi5jk86Jd1s0Y5wcQ1QgbVaAP5Q=w300", "00/00/0000")
        ));
    }

    public Single<List<AppVersion>> application(String name) {
        return Single.fromCallable(() -> Arrays.asList(
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", ""),
                new AppVersion("1.0.0", "38", "22/11/2017 23h59", "")
        ));
    }
}
