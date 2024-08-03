export const statusObj = {
    DONE: "Done",
    IN_PROGRESS: "In Progress",
    REVIEW: "Review",
    TODO: "To Do"
}

export const priorityObj = {
    LOW: "Low",
    MEDIUM: "Medium",
    TOP: "Top"
}

export const getPriority = (priority) => {
    if (typeof priority !== "string" || priority.trim() === "") {
        throw new Error("Invalid priority value");
    }

    return priority.toLowerCase()
}

export const getStatus = (status) => {
    if (typeof status !== "string" || status.trim() === "") {
        throw new Error("Invalid priority value")
    }

    const cleanedStatus = status.replace(/[\s_]+/g, "")
    return cleanedStatus.toLowerCase()
}

export const getDate = () => {
    const now = new Date()

    const day = now.getDate() < 10 ? "0" + now.getDate() : now.getDate()
    const month = now.getMonth() + 1 < 10 ? "0" + (now.getMonth() + 1) : now.getMonth() + 1
    const year = now.getFullYear()

    return `${year}-${month}-${day}`
}

export function getFormattedDate() {
    const now = new Date();

    const hours = String(now.getHours()).padStart(2, '0')
    const minutes = String(now.getMinutes()).padStart(2, '0')
    const seconds = String(now.getSeconds()).padStart(2, '0')

    return ` ${hours}:${minutes}:${seconds}`
}

export async function fetchTasks() {
    try {
      const response = await fetch('http://localhost:8083/tasks/all')
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText)
      }
      const data = await response.json()
      console.log(data)
      return data
    } catch (error) {
      console.error('There has been a problem with your fetch operation:', error)
    }
}

export const formatDate = (dateString) => {
    const date = new Date(dateString)

    if (isNaN(date.getTime())) {
      throw new Error("Invalid date format")
    }
  
    const options = { year: 'numeric', month: 'long', day: '2-digit' }
    return date.toLocaleDateString('en-US', options)
}

export async function createTask(taskData) {
    console.log(1)
    try {
      const response = await fetch('http://localhost:8083/tasks', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(taskData)
      });
  
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
  
      const data = await response.json();
      console.log('Task created:', data);
    } catch (error) {
      console.error('There was a problem with the fetch operation:', error);
    }
}

export function generateUniqueId() {
    return Date.now() + Math.floor(Math.random() * 1000)
}
  