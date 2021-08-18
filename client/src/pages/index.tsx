import { useEffect } from 'react';
import { useDispatch } from 'react-redux';

import { useRootState } from '@/hooks/useRootState';
import { loadPostsRequest } from '@/reducers/post/getAllPosts';
import SideBarMenu from '@/components/SideBarMenu';

interface homeProps {}

const Home: React.FC<homeProps> = ({}) => {
  const dispatch = useDispatch();
  const { allPosts } = useRootState((state) => state.post);

  useEffect(() => {
    dispatch(loadPostsRequest());
  }, [dispatch]);

  console.log(allPosts);

  return (
    <div>
      <SideBarMenu />
    </div>
  );
};

export default Home;
