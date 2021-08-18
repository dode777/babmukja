import React, { FC } from 'react';
import Image from 'next/image';

import { UserProfileImageWrapper } from './style';

import notLoginProfile from '@/assets/profile_box.png';
import testUserImage from '@/assets/testUserImage.png';

interface IUserProfileImageProps {
  isTestLogin: boolean;
}

function UserProfileImage({ isTestLogin }: IUserProfileImageProps) {
  return (
    <UserProfileImageWrapper>
      {isTestLogin ? (
        <Image src={testUserImage} alt={'Login user image'} />
      ) : (
        <Image src={notLoginProfile} alt={'Unlogged user icon'} />
      )}
    </UserProfileImageWrapper>
  );
}

export default UserProfileImage;
