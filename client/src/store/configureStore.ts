import { applyMiddleware, createStore, compose } from 'redux';

import { createWrapper } from 'next-redux-wrapper';
import { composeWithDevTools } from 'redux-devtools-extension';
import createSagaMiddleware from 'redux-saga';

import reducer from '@/reducers';
import rootSaga from '@/sagas';

const isProd = process.env.NODE_ENV === 'production';

const store = () => {
  const sagaMiddleware = createSagaMiddleware(); //sagaMiddleware 선언(미들웨어로 사용)
  const middlewares = [sagaMiddleware];
  const enhancer = isProd
    ? compose(applyMiddleware(...middlewares))
    : composeWithDevTools(applyMiddleware(...middlewares));

  const store: any = createStore(reducer, enhancer); //redux의 store 생성, 리듀서와 미들웨어 사용

  sagaMiddleware.run(rootSaga);
  return store;
};

const wrapper = createWrapper(store, {
  debug: !isProd,
});

export default wrapper;
