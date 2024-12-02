import $RefParser from "json-schema-ref-parser";
import { NgOpenApiGen } from "ng-openapi-gen";

const options = {
  input: "api/swagger/api-docs.yaml",
  output: "api/generate",
};

async function generateApiModule() {
  const RefParser = new $RefParser();
  const openApi = await RefParser.bundle(options.input, {
    dereference: { circular: false },
  });

  const ngOpenGen = new NgOpenApiGen(openApi, options);
  ngOpenGen.generate();
}

generateApiModule();
