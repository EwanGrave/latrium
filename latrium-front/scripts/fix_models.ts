import fs from 'fs';
import path from 'path';

const modelsPath = path.join(__dirname, '..', 'api', 'generate', 'models.ts');
const models = fs.readFileSync(modelsPath, 'utf-8');
const fixedModels = models.replace(/^export\s+/gm, 'export type ');
fs.writeFileSync(modelsPath, fixedModels);
