import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Banners from '@kestra-io/kestra-sdk/banners';
import type { Banner } from '@kestra-io/kestra-sdk';

function makeBanner(): Banner {
    return {
        message: `Test banner ${randomId()}`,
        type: 'INFO',
    };
}

describe('BannersApi', () => {
    it('searchBanners: returns a list of banners', async () => {
        const result = await Banners.searchBanners();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createBanner: creates a banner', async () => {
        const banner = makeBanner();
        const result = await Banners.createBanner(banner);
        expect(result).toBeDefined();
        expect((result as any).message).toBe(banner.message);
    });

    it('updateBanner: updates an existing banner', async () => {
        const created = await Banners.createBanner(makeBanner());
        const id = (created as any).id;
        const updated: Banner = { message: `Updated banner ${randomId()}`, type: 'WARNING', active: true };

        const result = await Banners.updateBanner({ ...updated, id });
        expect(result).toBeDefined();
        expect((result as any).message).toBe(updated.message);
    });

    it('deleteBanner: deletes a banner', async () => {
        const created = await Banners.createBanner(makeBanner());
        const id = (created as any).id;

        await Banners.deleteBanner({ id });
    });
});
