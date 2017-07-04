<?php
/**
 * Created by PhpStorm.
 * User: florentchampigny
 * Date: 18/06/2017
 * Time: 14:17
 */

//Affiche l'aide, et retourne le code 405 pour non-authorisé
function displayError($error){
    header('Content-Type: text/plain');
    header('HTTP/1.0 405 UNAUTHORIZED');

    echo $error;
    exit();
}

function resultJson($var){
    //header('Content-Type: application/json');
    echo json_encode($var);
    //logInfo((array)$var);
}