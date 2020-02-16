package com.example.onlineliquorfinal;

import com.example.onlineliquorfinal.serverresponse.SignUpResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import API.API;
import retrofit2.Call;
import retrofit2.Callback;

import static org.mockito.ArgumentMatchers.any;
@RunWith(MockitoJUnitRunner.class)
public class TestWithMockito {

    @Test
    public void TestWithMockito() {
        API loginAPI = Mockito.mock(API.class);
        final Call<SignUpResponse> mockedCall = Mockito.mock(Call.class);
//        when(loginAPI.checkUser("sadina123","sadina123")).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback<SignUpResponse> callback = invocation.getArgument(0, Callback.class);
//                callback.onResponse(mockedCall, Response.success(new LoginResponse()));

                // callback.onResponse(mockedCall, Response.success(new UserNotifications()));
                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));
    }

}
