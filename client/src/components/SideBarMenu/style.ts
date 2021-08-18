import styled from '@emotion/styled';

export const SideBarMenuWrapper = styled.div`
  max-width: 250px;
  width: 100%;
  height: 100vh;
  border-radius: 0 20px 20px 0;
  box-shadow: 25px 0px 25px -20px rgba(0, 0, 0, 0.25);
  padding: 2.5rem 0;
  position: fixed;
  overflow: hidden;
  z-index: 999;
  transition: 0.3s;
  &.menu__hidden {
    transition: 0.3s;
    transform: translateX(-200px);
    &:after {
      content: '';
      width: 50px;
      height: 100%;
      position: absolute;
      right: 0;
      top: 0;
      background-color: #fff;
    }
  }
`;

export const UserInfoBox = styled.div`
  display: flex;
  flex-wrap: wrap;
  row-gap: 15px;
  padding: 0 1.5rem;
`;

export const UserActionBox = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  font-size: 14px;
  column-gap: 5px;
  & a {
    font-weight: 400;
    display: flex;
    align-items: center;
  }
`;

export const UserInfoTextBox = styled.div`
  display: flex;
  flex-wrap: wrap;
  row-gap: 40px;
  & > h3 {
    font-size: 22px;
    position: relative;
    font-weight: 300;
    &:after {
      content: '';
      width: 36px;
      height: 4px;
      background-color: #eee;
      position: absolute;
      left: 0;
      bottom: -20px;
    }
  }
  & > p {
    font-size: 14px;
    font-weight: 300;
  }
`;

export const MenuBox = styled.nav`
  margin-top: 80px;
  & li {
    width: 200px;
    padding: 0.6rem 1.2rem;
    border-radius: 0px 50px 50px 0px;
    color: #000;
    display: flex;
    align-items: center;
    column-gap: 5px;
    position: relative;
    overflow: hidden;
    transition: 0.5s;
    cursor: pointer;
    &:after {
      content: '';
      width: 10px;
      height: 100%;
      background: ${(props) => props.theme.BACKGROUND_GRADIENT};
      position: absolute;
      left: -10px;
      z-index: -1;
      transition: 0.5s;
    }
    &:hover {
      &:after {
        left: 0;
      }
    }
    &.active {
      background: ${(props) => props.theme.BACKGROUND_GRADIENT};
      color: #fff;
    }
  }
`;

export const SideBarFooter = styled.div`
  width: 100%;
  position: absolute;
  bottom: 25px;
  text-align: center;
  & p {
    font-weight: 100;
    font-size: 0.8rem;
    color: #bbb;
  }
`;

export const ToggleActionBox = styled.div`
  width: 6px;
  height: 50px;
  background-color: #e3e3e3;
  border-radius: 50px;
  position: absolute;
  right: 20px;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
  z-index: 10;
`;
