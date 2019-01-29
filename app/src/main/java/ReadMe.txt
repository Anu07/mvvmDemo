/******************Readme.txt*****************************/
//Date-19June'18

This is a basic Mvvm demo which follows the architectural pattern Model-View-ViewModel.
Here we are fetching some random posts using Retrofit API.
There is a MainActivity class which has data binding done.
There is a model with name PostResponse.
Then,Here comes the role of ViewModel,We have PostDataModel with an CompositeDisposable in it,
which observes data flow from API.
