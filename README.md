[![Dynamic DevOps Roadmap](https://img.shields.io/badge/Dynamic_DevOps_Roadmap-559e11?style=for-the-badge&logo=Vercel&logoColor=white)](https://devopsroadmap.io/getting-started/)
[![Community](https://img.shields.io/badge/Join_Community-%23FF6719?style=for-the-badge&logo=substack&logoColor=white)](https://newsletter.devopsroadmap.io/subscribe)
[![Telegram Group](https://img.shields.io/badge/Telegram_Group-%232ca5e0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/DevOpsHive/985)
[![Fork on GitHub](https://img.shields.io/badge/Fork_On_GitHub-%2336465D?style=for-the-badge&logo=github&logoColor=white)](https://github.com/DevOpsHiveHQ/devops-hands-on-project-hivebox/fork)

# HiveBox - DevOps End-to-End Hands-On Project

<p align="center">
  <a href="https://devopsroadmap.io/projects/hivebox" style="display: block; padding: .5em 0; text-align: center;">
    <img alt="HiveBox - DevOps End-to-End Hands-On Project" border="0" width="90%" src="https://devopsroadmap.io/img/projects/hivebox-devops-end-to-end-project.png" />
  </a>
</p>

> [!CAUTION]
> **[Fork](https://github.com/DevOpsHiveHQ/devops-hands-on-project-hivebox/fork)** this repo, and create PRs in your fork, **NOT** in this repo!

> [!TIP]
> If you are looking for the full roadmap, including this project, go back to the [getting started](https://devopsroadmap.io/getting-started) page.

This repository is the starting point for [HiveBox](https://devopsroadmap.io/projects/hivebox/), the end-to-end hands-on project.

You can fork this repository and start implementing the [HiveBox](https://devopsroadmap.io/projects/hivebox/) project. HiveBox project follows the same Dynamic MVP-style mindset used in the [roadmap](https://devopsroadmap.io/).

The project aims to cover the whole Software Development Life Cycle (SDLC). That means each phase will cover all aspects of DevOps, such as planning, coding, containers, testing, continuous integration, continuous delivery, infrastructure, etc.

Happy DevOpsing ♾️

## Before you start

Here is a pre-start checklist:

- ⭐ <a target="_blank" href="https://github.com/DevOpsHiveHQ/dynamic-devops-roadmap">Star the **roadmap** repo</a> on GitHub for better visibility.
- ✉️ <a target="_blank" href="https://newsletter.devopsroadmap.io/subscribe">Join the community</a> for the project community activities, which include mentorship, job posting, online meetings, workshops, career tips and tricks, and more.
- 🌐 <a target="_blank" href="https://t.me/DevOpsHive/985">Join the Telegram group</a> for interactive communication.

## Preparation

- [Create GitHub account](https://docs.github.com/en/get-started/start-your-journey/creating-an-account-on-github) (if you don't have one), then [fork this repository](https://github.com/DevOpsHiveHQ/devops-hands-on-project-hivebox/fork) and start from there.
- [Create GitHub project board](https://docs.github.com/en/issues/planning-and-tracking-with-projects/creating-projects/creating-a-project) for this repository (use `Kanban` template).
- Each phase should be presented as a pull request against the `main` branch. Don’t push directly to the main branch!
- Document as you go. Always assume that someone else will read your project at any phase.
- You can get senseBox IDs by checking the [openSenseMap](https://opensensemap.org/) website. Use 3 senseBox IDs close to each other (you can use the following [5eba5fbad46fb8001b799786](https://opensensemap.org/explore/5eba5fbad46fb8001b799786), [5c21ff8f919bf8001adf2488](https://opensensemap.org/explore/5c21ff8f919bf8001adf2488), and [5ade1acf223bd80019a1011c](https://opensensemap.org/explore/5ade1acf223bd80019a1011c)). Just copy the IDs, you will need them in the next steps.

<br/>
<p align="center">
  <a href="https://devopsroadmap.io/projects/hivebox/" imageanchor="1">
    <img src="https://img.shields.io/badge/Get_Started_Now-559e11?style=for-the-badge&logo=Vercel&logoColor=white" />
  </a><br/>
</p>

---

## Implementation

## 🏗️ 1. Building Images
Run these commands from the directory containing your `Dockerfile`.

| Command | Description |
| :--- | :--- |
| `docker build -t <image-name> .` | Build an image with a specific tag (name). |
| `docker build -t <image-name>:<tag> .` | Build an image with a version (e.g., `myapp:v1`). |
| `docker images` | List all locally stored images. |
| `docker rmi <image-id>` | Remove a specific image. |

---

## 🚀 2. Running Containers
The `-p` flag is mandatory to access your Spring Boot app from your browser.

| Command | Description |
| :--- | :--- |
| `docker run -p 8080:8080 <image-name>` | Run container in the foreground (attached). |
| `docker run -d -p 8080:8080 <image-name>` | Run in **Detached mode** (background). |
| `docker run --name <name> -p 8080:8080 <image-name>` | Run and assign a custom name to the container. |
| `docker run -e "SPRING_PROFILES_ACTIVE=dev" <image>` | Pass **Environment Variables** to Spring. |

---

## 🛠️ 3. Managing Containers
Use these to control containers that are already created.

| Command | Description |
| :--- | :--- |
| `docker ps` | Show **Running** containers. |
| `docker ps -a` | Show **All** containers (including stopped/exited). |
| `docker stop <name-or-id>` | Stop a running container gracefully. |
| `docker start <name-or-id>` | Start a previously stopped container. |
| `docker rm -f <name-or-id>` | Force remove a container (even if running). |

---

## 🔍 4. Debugging & Logs
Essential for when your Spring app throws an exception during startup.

| Command | Description |
| :--- | :--- |
| `docker logs <name-or-id>` | Fetch all logs from the container. |
| `docker logs -f <name-or-id>` | **Follow** logs (real-time stream). |
| `docker exec -it <name-or-id> /bin/sh` | Open a terminal **inside** the container. |
| `docker inspect <name-or-id>` | View detailed JSON metadata (IPs, mounts, etc). |

---

## 🧹 5. Cleanup
Docker can eat up disk space quickly on Ubuntu. Use these to stay organized.

* **Remove all stopped containers:**
  ```bash
  docker container prune
