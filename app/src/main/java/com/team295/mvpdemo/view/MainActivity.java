package com.team295.mvpdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.team295.mvpdemo.R;
import com.team295.mvpdemo.model.GithubUser;
import com.team295.mvpdemo.model.GithubUserResponse;
import com.team295.mvpdemo.presenter.GithubPresenter;
import com.team295.mvpdemo.service.contractor.GithubUserView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GithubUserView {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.users_list);

        loadUsers();
        loadSingleUser();

    }

    private void loadUsers() {
        GithubPresenter.returnPresenterInstance().fetchGithubUsers(this);
    }

    private void loadSingleUser() {
        GithubPresenter.returnPresenterInstance().fetchSingleUser("kiptechie", this);
    }

    private void initializeListView(ArrayList<String> response) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_view, response);
        listView.setAdapter(adapter);
    }

    @Override
    public void allGithubUsers(MutableLiveData<GithubUserResponse> response) {
        response.observe(this, new Observer<GithubUserResponse>() {
            @Override
            public void onChanged(GithubUserResponse githubUserResponse) {
                String myName;
                ArrayList<String> stringArrayList = new ArrayList<>();
                for (GithubUser githubUser : githubUserResponse.getGithubUsers()) {
                    myName = githubUser.getUserName();
                    stringArrayList.add(myName);
                }
                initializeListView(stringArrayList);
            }
        });
    }

    @Override
    public void singleGithubUser(GithubUser githubUser) {
        Log.d("SINGLEUSER", githubUser.toString());

    }
}