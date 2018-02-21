<?php

$plugin = $_REQUEST['plugin'];
$version = $_REQUEST['version'];
if($plugin=="Skilled"){
    define("Latest", "1.2.0");
    if($version==Latest)
        echo "no";
    else
        echo "yes";
}
if($plugin=="WTP"){
    define("Latest", "2.1.1");
    if($version==Latest)
        echo "no";
    else
        echo "yes";
}
?>
