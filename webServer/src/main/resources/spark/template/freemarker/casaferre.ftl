<!DOCTYPE html>
<#import "includes/basePage.ftl" as basePage />
<html lang="sv" xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml">
<@basePage.casaFerreHeader "CasaFerre", "/" />
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="/imgs/logo.png" width="60" height="40">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a></li>
                <li class="nav-item"><a class="nav-link" href="#">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<header class="bg-primary py-5 mb-5">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-lg-12">
                <h1 class="display-4 text-white mt-5 mb-2">CasaFerre Konsulting</h1>
                <p class="lead mb-5 text-white-50">
                    Ett konsultbolag för sjukvård, eHälsa med expertkunskaper inom </p>
                <ul class="text-white-50">
                    <li>Snomed-CT</li>
                    <li>Projektledning</li>
                </ul>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-md-8 mb-5">
            <h2>Vad är CasaFerre?</h2>
            <hr>
            <p>CasaFerre är ett ...</p>
            <p>Vi har ...</p>
            <a class="btn btn-primary btn-lg" href="#">Call to Action &raquo;</a>
        </div>
        <div class="col-md-4 mb-5">
            <h2>Kontakt</h2>
            <hr>
            <address>
                <strong>CasaFerre</strong>
                <br>Björnstorp 883
                <br>247 98 Genarp
                <br>
            </address>
            <address>
                <abbr title="Email">E-post: </abbr>
                <a href="mailto:lena@casaferre.se">lena@casaferre.se</a>
            </address>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-md-4 mb-5">
            <div class="card h-100">
                <img class="card-img-top" src="http://placehold.it/300x200" alt="">
                <div class="card-body">
                    <h4 class="card-title">Card title</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Find Out More!</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-5">
            <div class="card h-100">
                <img class="card-img-top" src="http://placehold.it/300x200" alt="">
                <div class="card-body">
                    <h4 class="card-title">Card title</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus totam ut praesentium aut.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Find Out More!</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-5">
            <div class="card h-100">
                <img class="card-img-top" src="http://placehold.it/300x200" alt="">
                <div class="card-body">
                    <h4 class="card-title">Card title</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Find Out More!</a>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; CasaFerre ${.now?string('yyyy')}</p>
    </div>
</footer>
</body>
</html>