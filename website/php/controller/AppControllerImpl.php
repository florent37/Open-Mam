<?php

/**
 * Created by PhpStorm.
 * User: florentchampigny
 * Date: 18/06/2017
 * Time: 14:01
 */
class AppControllerImpl implements AppController
{

    protected $appRepository;
    protected $fileSaver;

    /**
     * AppControllerImpl constructor.
     */
    public function __construct(AppRepository $appRepository, FileSaver $fileSaver)
    {
        $this->appRepository = $appRepository;
        $this->fileSaver = $fileSaver;

        $this->init();
    }

    public function init()
    {
        //create DB if necessary
        createDatabase();
    }

    public function start($params)
    {
        // index.php ? method=
        if (isset($params["method"]))
            $method = $params["method"];
        else {
            displayError("missing param 'method'");
            return;
        }

        switch ($method) {
            case "upload" :
                $this->startUpload($params, $files);
                break;
            case "apps" :
                $response = new AppsResponse();
                $response->apps = $this->provideApplications();
                resultJson($response);
                break;
            case "app" :
                if (isset($params["name"])) {
                    $response = new AppVersionResponse();
                    $response->versions = $this->provideApplication($params["name"]);
                    resultJson($response);
                } else {
                    displayError("missing param 'name'");
                }
                break;
        }
    }

    public function provideApplications()
    {
        $applications = $this->appRepository->provideApplications();
        return $applications;
    }

    public function provideApplication($name)
    {
        $appVersions = $this->appRepository->provideApplication($name);
        return $appVersions;
    }

    function startUpload($params)
    {
        $appName = $params["name"];
        $package = $params["package"];
        $apkName = $params["apkName"];
        $appVersion = $params["version"];
        $appCode = $params["code"];
        $comment = $params["comment"];

        //save the apk into tmpFiles

        $outputFileName = "tmpFiles/$apkName";
        $putdata = fopen("php://input", "r");
        $fp = fopen($outputFileName, "w");
        while ($data = fread($putdata, 1024)) {
            fwrite($fp, $data);
        }
        fclose($fp);
        fclose($putdata);

        $fileUrl = $this->fileSaver->saveApk($outputFileName);
        $this->appRepository->addAppVersion($appName, $package, $appVersion, $appCode, $comment, $fileUrl);

        // TODO: Implement startUpload() method.
    }
}