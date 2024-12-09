import { formatDate } from '@angular/common';
import shajs from 'sha.js';

type Algorithm = 'sha' | 'sha1' | 'sha224' | 'sha256' | 'sha384' | 'sha512';

export function shaEncrypt(str: string, encryption: Algorithm): string {
  return shajs(encryption).update(str).digest('hex');
}

export const DATE_FORMAT: string = 'dd/MM/YYYY à HH:mm';

export function formatDateFromString(str: string): string {
  return formatDate(new Date(str), DATE_FORMAT, 'fr-FR');
}
