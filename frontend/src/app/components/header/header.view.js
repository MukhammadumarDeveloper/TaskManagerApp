import "./header.scss";
import logo from "../../../assets/imgs/logo.svg";

export class HeaderView {
    selector = "header"

    constructor() {
        this.render()
    }

    render() {
        document.getElementById(this.selector).innerHTML = `
            <div class="header--top">
                <div class="header--logo logo">
                    <img class="logo--image" src="${logo}" alt="logo" />
                    <h1 class="logo--heading">TaskTrack</h1>
                </div>
                <button id="header-menu" class="menu__btn">
                    <i class="fa-solid fa-bars"></i>
                </button>
                <button id="header-logout" class="logout__btn">
                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                </button>
            </div>
            <div class="line"></div>
            <div class="header--bottom">
                <div class="personal-info">
                    <div class="personal-info--top">
                        <h2 class="personal-info--name">Welcome Jane!</h2>
                        <p class="personal-info--role">Editor</p>
                    </div>
                    <p class="personal-info--question">What is on due today?</p>
                </div>
                <div class="phone-number">
                    <p class="phone-number--top">User phone number</p>
                    <p class="phone-number--bottom">+9998 99 212 12 12</p>
                </div>
            </div>

            <div class="header__menu">
                <div class="personal-info--top">
                        <h2 class="personal-info--name">Jane Cooper!</h2>
                        <p class="personal-info--role">Editor</p>
                    </div>
                <p class="phone-number--bottom">+9998 99 212 12 12</p>
                <button type="button">
                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                    Log out
                </button>
            </div>
        `;

        const menuIcon = document.querySelector(".fa-bars");
        const menu = document.querySelector(".header__menu")
        menuIcon.addEventListener('click', () => {
            menuIcon.classList.toggle('fa-xmark');
            menu.classList.toggle("header__menu-active")

            if(menu.classList.contains("header__menu-active")) {
                document.getElementById(this.selector).style.overflow = "visible"
            } else {
                document.getElementById(this.selector).style.overflow = "hidden"
            }
        });
    }
}
