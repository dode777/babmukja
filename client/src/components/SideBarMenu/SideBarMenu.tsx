import React, { FC, useState, useEffect } from 'react';
import Link from 'next/link';
import Image from 'next/image';
import { useRouter } from 'next/router';
import { MapOutlined, ListAltOutlined } from '@material-ui/icons';
import {
  SideBarMenuWrapper,
  UserInfoBox,
  UserInfoTextBox,
  MenuBox,
  SideBarFooter,
  ToggleActionBox,
  UserActionBox,
} from './style';

import LoginIcon from '@/assets/login_icon.png';
import Notification_on from '@/assets/notification_on.png';
import Notification_off from '@/assets/notification_off.png';

import UserProfileImage from '@/components/UserProfileImage';

const menuData: { name: string; path: string; icon: React.ReactNode }[] = [
  { name: '지도', path: '/', icon: <MapOutlined /> },
  { name: '리스트', path: '/list', icon: <ListAltOutlined /> },
];

const SideBarMenu: FC = () => {
  const { pathname } = useRouter();
  const [isTestLogin, setTestLogin] = useState<boolean>(false);
  const [isNotification, setNotification] = useState<boolean>(false);
  const [toggle, setToggle] = useState<boolean>(false);

  const handleLoginTest = () => {
    setTestLogin((prev) => !prev);
  };

  const handleToggleMenu = () => {
    setToggle((prev) => !prev);
  };
  return (
    <SideBarMenuWrapper className={toggle ? 'menu__hidden' : ''}>
      <UserInfoBox>
        <UserActionBox>
          {isTestLogin &&
            (isNotification ? (
              <Image src={Notification_on} alt="notification on" />
            ) : (
              <Image src={Notification_off} alt="notification off" />
            ))}
          <Link href="/">
            <a onClick={handleLoginTest}>
              <Image src={LoginIcon} alt="login and logout icon" />
              <span>{isTestLogin ? '로그아웃' : '로그인'}</span>
            </a>
          </Link>
        </UserActionBox>
        <UserProfileImage isTestLogin={isTestLogin} />
        <UserInfoTextBox>
          {isTestLogin ? (
            <>
              <h3>반가워요 한윤성님!</h3>
              <p>인천시 마포구에 계시는군요!</p>
            </>
          ) : (
            <>
              <h3>로그인이 필요합니다.</h3>
              <p>
                밥묵자에서
                <br />
                오늘의 식사친구를 찾아보세요 :)
              </p>
            </>
          )}
        </UserInfoTextBox>
      </UserInfoBox>
      <ToggleActionBox className="toggle__action" onClick={handleToggleMenu} />
      <MenuBox>
        <ul>
          {menuData.map((d) => (
            <Link key={d.path} href={d.path}>
              <li className={pathname === d.path ? 'active' : ''}>
                {d.icon}
                {d.name}
              </li>
            </Link>
          ))}
        </ul>
      </MenuBox>
      <SideBarFooter>
        <p>&#169; 2021.doongji.All rights reserved</p>
      </SideBarFooter>
    </SideBarMenuWrapper>
  );
};

export default SideBarMenu;
