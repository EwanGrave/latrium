import fetch from "node-fetch";
import fs from "fs/promises";

const options = {
  baseUrl: "http://localhost:8080",
  output: "api/swagger/api-docs.yaml",
};

async function isPathValid(path) {
  try {
    await fs.access(path);
    return true;
  } catch {
    return false;
  }
}

async function getOpenApiSpec() {
  try {
    const response = await fetch(options.baseUrl + "/v3/api-docs.yaml");
    const data = await response.text();

    const exist = await isPathValid("api/swagger");
    if (!exist) {
      await fs.mkdir("api/swagger", { recursive: true });
    }

    await fs.writeFile(options.output, data);
  } catch (e) {
    console.error(e.message);
  }
}

getOpenApiSpec();
