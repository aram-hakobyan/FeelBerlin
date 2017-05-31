package de.feelberlin.android.api;

public interface ResultHandler {

    <ResultType> void onSuccess(ResultType result);

    void onError(String errorMessage);
}