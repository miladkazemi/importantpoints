package com.devst0rm.importantpoints.remote.APIService.point;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.devst0rm.importantpoints.model.Categories_M;
import com.devst0rm.importantpoints.model.Points_M;
import com.devst0rm.importantpoints.remote.APIService.APIS_Point;
import com.devst0rm.importantpoints.remote.httpServer.RetroClass;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PointRepository {

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                       { Variable }    { Variable }    { Variable }                                       */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    private final MutableLiveData<ArrayList<Categories_M>> liveData_category = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Points_M>> liveData_point = new MutableLiveData<>();



    private Context context;
    private APIS_Point apiService;

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                   { Constructor }    { Constructor }    { Constructor }                                  */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public PointRepository(Context context) {
        this.context = context;
        if (apiService == null) {
            apiService = RetroClass.getAPIS_Point();
        }
    }



    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                         { Methods }    { Methods }    { Methods }                                        */
    /*--------------------------------------------------------------------------------------------------------------------------*/


    public void getCategories() {
        Observable<CategoryListRes_M> mObservable = apiService.getCategories();
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryListRes_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryListRes_M categoryListResM) {
                        if (categoryListResM.getStatus().isOk()) {
                            liveData_category.postValue(categoryListResM.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getPoints(String categories) {
        Observable<PointListRes_M> mObservable = apiService.getPoints(categories);
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PointListRes_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PointListRes_M pointListResM) {
                        if (pointListResM.getStatus().isOk()) {
                            liveData_point.postValue(pointListResM.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("jdkjkljkadj", "tt: " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                            { Getter }    { And }    { Setter }                                           */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public MutableLiveData<ArrayList<Categories_M>> getLiveData_category() {
        return liveData_category;
    }

    public MutableLiveData<ArrayList<Points_M>> getLiveData_point() {
        return liveData_point;
    }
}
