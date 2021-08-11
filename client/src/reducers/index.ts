import { combineReducers } from 'redux';
import post from './post';

const rootReducer = combineReducers({
  post,
});

export default rootReducer;

export type RootState = ReturnType<typeof rootReducer>;
