/*
 * Copyright (C) 2016 Felipe Joglar Santos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fjoglar.etsitnoticias.domain.usecase;

import com.fjoglar.etsitnoticias.domain.UseCase;
import com.fjoglar.etsitnoticias.data.repository.NewsDataSource;

public class UpdateNews extends UseCase<UpdateNews.RequestValues, UpdateNews.ResponseValue> {

    private final NewsDataSource mNewsDataSource;

    public UpdateNews(NewsDataSource mNewsDataSource) {
        this.mNewsDataSource = mNewsDataSource;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        mNewsDataSource.updateNews(new NewsDataSource.UpdateNewsCallback() {
            @Override
            public void onUpdateFinished(Boolean isUpdated) {
                if (isUpdated) {
                    getUseCaseCallback().onSuccess(new ResponseValue());
                } else {
                    getUseCaseCallback().onError();
                }
            }
        });

    }

    public static final class RequestValues implements UseCase.RequestValues {
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
    }

}
