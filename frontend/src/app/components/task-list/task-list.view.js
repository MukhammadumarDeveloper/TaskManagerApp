import { fetchTasks, formatDate, getPriority, getStatus, priorityObj, statusObj } from "../../../utils"
import plus from "../../../assets/imgs/plus.svg"
import "./task-list.scss"
import { ModalView } from "../modal/modal.view"

const statuses = [
    "To Do",
    "In Progress",
    "Review",
    "Done",
]

const tasks = [
    {
        name: "Visual Design",
        desc: "Establish a disign system that includes color palettes",
        priority: "High",
        status: "Review",
    },
    {
        name: "Visual Design",
        desc: "Establish a disign system that includes color palettes",
        priority: "Medium",
        status: "To Do",
    },
]

export class TaskListView {
    selector = "main"

    constructor() {
        this.render()
    }

    render() {
        document.getElementById(this.selector).innerHTML = `
            <div class="container">
                <div class="board__wrapper"></div>
            </div>
        `

        this.renderStatusBlock()
        
    }

    renderStatusBlock() {
        const boardWrapper = document.querySelector(".board__wrapper")
        statuses.forEach(status => {
            const board = document.createElement("div")
            board.classList.add("board__block")
            board.innerHTML = `
                <div class="board__block-status">
                    <h2>${status}</h2>
                    <button type="button" class="plus_btn" data-status="${status}">
                        <img src="${plus}" alt="plus" />
                    </button>
                </div>
                <div class="board__${getStatus(status)}-block"></div>
                <button type="button" class="add_card-btn" data-status="${status}">
                    <img src="${plus}" alt="plus" />
                    Add a card
                </button> 
            `
            boardWrapper.appendChild(board)
        })

        document.querySelectorAll(".plus_btn").forEach(btn => {
            btn.addEventListener("click", (event) => {
                const status = event.currentTarget.getAttribute("data-status")
                let taskStatus = ""
                for (const [key, val] of Object.entries(statusObj)) {
                    if (val === status) {
                        taskStatus = key
                    }
                }
                const modalView = new ModalView()
                modalView.render(null, taskStatus, "task-list")
            })
        })

        document.querySelectorAll(".add_card-btn").forEach(btn => {
            btn.addEventListener("click", (event) => {
                const status = event.currentTarget.getAttribute("data-status")
                let taskStatus = ""
                for (const [key, val] of Object.entries(statusObj)) {
                    if (val === status) {
                        taskStatus = key
                    }
                }
                const modalView = new ModalView()
                modalView.render(null, taskStatus, "task-list")
            })
        })

        this.renderTasks()

    }

    async renderTasks() {
        const data = await fetchTasks()

        data.forEach(task => {
            const taskBlock = document.createElement("div")
            taskBlock.setAttribute("data-id", task.id)
            taskBlock.classList.add("task__block")
            taskBlock.innerHTML = `
                <h3 class="task__title">${task.title}</h3>
                <p class="task__desc">${task.content}</p>
                <div class="task__inf-dates">
                    <span class="board__${getPriority(task.priority)}">${priorityObj[task.priority]} Priority</span>
                    <span>${formatDate(task.dueDate)}</span>
                </div>
            `

            document.querySelector(`.board__${getStatus(task.status)}-block`).appendChild(taskBlock)
        })
    }
}