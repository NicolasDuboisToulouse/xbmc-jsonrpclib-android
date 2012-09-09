/*
 *      Copyright (C) 2005-2015 Team XBMC
 *      http://xbmc.org
 *
 *  This Program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2, or (at your option)
 *  any later version.
 *
 *  This Program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with XBMC Remote; see the file license.  If not, write to
 *  the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 *  http://www.gnu.org/copyleft/gpl.html
 *
 */

package org.xbmc.android.jsonrpc.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public final class LibraryModel {
	/**
	 * Library.Details.Genre
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GenreDetails extends ItemModel.BaseDetails {
		public final static String API_TYPE = "Library.Details.Genre";
		// field names
		public static final String GENREID = "genreid";
		public static final String THUMBNAIL = "thumbnail";
		public static final String TITLE = "title";
		// class members
		public final int genreid;
		public final String thumbnail;
		public final String title;
		/**
		 * Construct from JSON object.
		 * @param obj JSON object representing a GenreDetails object
		 */
		public GenreDetails(ObjectNode node) {
			super(node);
			mType = API_TYPE;
			genreid = node.get(GENREID).getIntValue();
			thumbnail = parseString(node, THUMBNAIL);
			title = parseString(node, TITLE);
		}
		@Override
		public ObjectNode toObjectNode() {
			final ObjectNode node = OM.createObjectNode();
			node.put(GENREID, genreid);
			node.put(THUMBNAIL, thumbnail);
			node.put(TITLE, title);
			return node;
		}
		/**
		 * Extracts a list of {@link LibraryModel.GenreDetails} objects from a JSON array.
		 * @param obj ObjectNode containing the list of objects
		 * @param key Key pointing to the node where the list is stored
		 */
		static ArrayList<LibraryModel.GenreDetails> getLibraryModelGenreDetailsList(ObjectNode node, String key) {
			if (node.has(key)) {
				final ArrayNode a = (ArrayNode)node.get(key);
				final ArrayList<LibraryModel.GenreDetails> l = new ArrayList<LibraryModel.GenreDetails>(a.size());
				for (int i = 0; i < a.size(); i++) {
					l.add(new LibraryModel.GenreDetails((ObjectNode)a.get(i)));
				}
				return l;
			}
			return new ArrayList<LibraryModel.GenreDetails>(0);
		}
		/**
		 * Flatten this object into a Parcel.
		 * @param parcel the Parcel in which the object should be written
		 * @param flags additional flags about how the object should be written
		 */
		@Override
		public void writeToParcel(Parcel parcel, int flags) {
			super.writeToParcel(parcel, flags);
			parcel.writeValue(genreid);
			parcel.writeValue(thumbnail);
			parcel.writeValue(title);
		}
		@Override
		public int describeContents() {
			return 0;
		}
		/**
		 * Construct via parcel
		 */
		protected GenreDetails(Parcel parcel) {
			super(parcel);
			genreid = parcel.readInt();
			thumbnail = parcel.readString();
			title = parcel.readString();
		}
		/**
		 * Generates instances of this Parcelable class from a Parcel.
		 */
		public static final Parcelable.Creator<GenreDetails> CREATOR = new Parcelable.Creator<GenreDetails>() {
			@Override
			public GenreDetails createFromParcel(Parcel parcel) {
				return new GenreDetails(parcel);
			}
			@Override
			public GenreDetails[] newArray(int n) {
				return new GenreDetails[n];
			}
		};
	}
	public interface GenreFields {
		public final String TITLE = "title";
		public final String THUMBNAIL = "thumbnail";
	}
}