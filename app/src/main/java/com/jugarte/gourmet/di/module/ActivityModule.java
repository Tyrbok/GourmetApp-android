package com.jugarte.gourmet.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.jugarte.gourmet.ThreadManager;
import com.jugarte.gourmet.ThreadManagerImp;
import com.jugarte.gourmet.data.prefs.AppPreferencesHelper;
import com.jugarte.gourmet.data.prefs.PreferencesHelper;
import com.jugarte.gourmet.domine.user.GetUser;
import com.jugarte.gourmet.domine.user.SaveUser;
import com.jugarte.gourmet.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    Context provideContext() {
        return activity.getApplicationContext();
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    LoginPresenter provideLoginPresenter(GetUser getUser, SaveUser saveUser, ThreadManager threadManager) {
        return new LoginPresenter(getUser, saveUser, threadManager);
    }

    @Provides
    GetUser provideGetUser(PreferencesHelper preferencesHelper) {
        return new GetUser(preferencesHelper);
    }

    @Provides
    SaveUser provideSaveUser(PreferencesHelper preferencesHelper) {
        return new SaveUser(preferencesHelper);
    }

    @Provides
    PreferencesHelper getPreferenceHelper(Context context) {
        return new AppPreferencesHelper(context);
    }

    @Provides
    ThreadManager provideThreadManager() {
        return new ThreadManagerImp();
    }

}