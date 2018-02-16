package com.dopamin.mestaslovenije;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

/**
 * Created by Žiga on 15. 02. 2018.
 */

public class ServicesController {

    private Context context;
    public static final int SERVICES_REQUEST_ID = 1515151515;
    private static final int RC_LEADERBOARD_UI = 9004;

    public ServicesController(Context context){
        this.context = context;
    }


    public boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(context) != null;
    }

    public void showLeaderboard() {
        Games.getLeaderboardsClient(context, GoogleSignIn.getLastSignedInAccount((MainActivity)context))
                .getLeaderboardIntent(context.getString(R.string.leaderboard))
                .addOnSuccessListener(new OnSuccessListener<Intent>() {
                    @Override
                    public void onSuccess(Intent intent) {
                        ((Activity) context).startActivityForResult(intent, RC_LEADERBOARD_UI);
                    }
                });
    }

    public void submitScore(long score){
        Games.getLeaderboardsClient(context, GoogleSignIn.getLastSignedInAccount((MainActivity)context)).submitScore(context.getString(R.string.leaderboard), score);
    }

    public void signInSilently() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        signInClient.silentSignIn().addOnCompleteListener((MainActivity) context,
                new OnCompleteListener<GoogleSignInAccount>() {
                    @Override
                    public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                        if (task.isSuccessful()) {
                            // The signed in account is stored in the task's result.
                            GoogleSignInAccount signedInAccount = task.getResult();
                        } else {
                            // Player will need to sign-in explicitly using via UI
                        }
                    }
                });
    };

    public void startSignInIntent() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        Intent intent = signInClient.getSignInIntent();
        ((Activity)context).startActivityForResult(intent, SERVICES_REQUEST_ID);
    }

    public void onActivityResult(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        if (result.isSuccess()) {
            // The signed in account is stored in the result.
            GoogleSignInAccount signedInAccount = result.getSignInAccount();
        } else {
            String message = result.getStatus().getStatusMessage();
            if (message == null || message.isEmpty()) {
                message = "Prijava neuspešna";
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }


}
