/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.view;

import android.os.Parcelable;
import android.view.View;

/**
 * Base class providing the adapter to populate pages inside of
 * a {@link ViewPager}.  You will most likely want to use a more
 * specific implementation of this, such as
 * {@link android.support.v4.app.FragmentPagerAdapter} or
 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
 */
public abstract class PagerAdapter {
    /**
     * Return the number of fragments available.
     */
    public abstract int getCount();

    /**
     * Called when a change in the shown pages is going to start being made.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
    public abstract void startUpdate(View container);

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate()}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    public abstract Object instantiateItem(View container, int position);

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate()}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
    public abstract void destroyItem(View container, int position, Object object);

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
    public abstract void finishUpdate(View container);

    public abstract boolean isViewFromObject(View view, Object object);

    public abstract Parcelable saveState();

    public abstract void restoreState(Parcelable state, ClassLoader loader);
}
