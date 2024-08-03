import { DashboardController } from "../dashboard/dashboard.controller"
import { TaskListController } from "../task-list/task-list.controller"
import "./pagination.scss"

export class PaginationView {
    selector = "pagination"

    constructor() {
    }

    render() {
        document.getElementById(this.selector).innerHTML = `
            <div class="container">
                <div class="pagination__wrapper">
                    <button class="pagination__btn table__view-btn" data-layout="table">Table view</button>
                    <button class="pagination__btn board__view-btn" data-layout="board">Board view</button>
                </div>
            </div>
        `

        const paginationWrapper = document.querySelector(".pagination__wrapper")
        paginationWrapper.querySelectorAll("button").forEach(button => {
            button.addEventListener("click", (event) => {
                this.handleButtonClick(event.target)
            })
        })

        const defaultBtn = paginationWrapper.querySelector(".table__view-btn")
        this.handleButtonClick(defaultBtn)
    }

    handleButtonClick(button) {
        const buttons = document.querySelectorAll(".pagination__wrapper button")
        buttons.forEach(btn => btn.classList.remove("active__btn"))

        if (button.dataset.layout === 'table') {
            button.classList.add("active__btn")
            new DashboardController()
        } else if (button.dataset.layout === 'board') {
            button.classList.add("active__btn")
            new TaskListController()
        }
    }
}